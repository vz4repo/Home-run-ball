<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
</head>
<style>
    /*.dlvAddrList {*/
    /*    border: 1px solid black;*/
    /*    padding: 10px;*/
    /*    margin-bottom: 10px;*/
    /*    width: 50%; !* 50% width *!*/
    /*}*/
    /*.dlvAddrList table {*/
    /*    margin: 0 auto; !* 테이블 가운데 정렬 *!*/
    /*}*/
    /*.dlvAddrList button {*/
    /*    margin-left: 10px;*/
    /*}*/

    /*.modal{*/
    /*    position:absolute;*/
    /*    top:50%;*/
    /*    width:400px;*/
    /*    height:600px;*/
    /*    padding:40px;*/
    /*    text-align: center;*/
    /*    background-color: rgb(255,255,255);*/
    /*    border-radius:10px;*/
    /*    box-shadow:0 2px 3px 0 rgba(34,36,38,0.15);*/
    /*    transform:translateY(-50%);*/
    /*}*/


    /* 배송창에 맞게 여기서부터 고치기*/

    #deliveryForm {
        display: flex;
        justify-content: center;
        flex-wrap: wrap; /* 요소가 너무 많을 때 다음 줄로 넘어갈 수 있도록 설정 */
    }

    table {
        width: 90%;
        margin: 0 auto;
        text-align: left;
        font-size: 12px;
        line-height: 1.35;
        color: #777;
    }

    a {
        text-decoration: none;
        color: black;
    }

    th, td {
        text-align: center;
    }

    td {
        padding: 15px 0;
    }

    #delivery_left {
        text-align: center;
        width: 20%;
        height: 100%;
    }

    #delivery_right {
        width: 80%;
        height: 100%;
    }

</style>
<body>


<%-- 고객이 선택한 배송지 뜨는 페이지 _ order.jsp --%>
<div>
    <div id = "delivery_left" class="head_order">
        Delivery
    </div>
    <div id = "delivery_right">
    </div>
</div>

<hr class="first__under" />
<div id="selectedDLV" class="center-table">
    <table>
        <tr>
            <%-- c_id : 고객 번호--%>
            <td>고객 C_ID</td>
            <td>${sessionScope.c_id}</td>
        </tr>
        <tr>
            <%-- rcver : 고객명 / --%>
            <td>이름(장소명)</td>
            <td>${selectedDto.rcver}(${selectedDto.adr_name})</td>
        </tr>
        <tr>
            <%-- rcver_phn : 고객 연락처 --%>
            <td>연락처</td>
            <td>${selectedDto.rcver_phn}</td>
        </tr>
        <tr>
            <%-- rcver_adr : 고객 주소--%>
            <td>주소</td>
            <td>${selectedDto.rcver_adr}</td>
        </tr>
        <tr>
            <td colspan="2">
                <%-- 여기서 배송지 변경 버튼 누르면, deliveryList.jsp 페이지로 이동해야한다. --%>
                <%--<button id="changeAdrList" onclick="redirectToDeliveryList()">배송지 변경</button>--%>
                <button id="selectAllBtn">배송지 전체 조회</button>
            </td>
        </tr>
    </table>
</div>
<hr />



<%--<div class="modal" style="display: none">--%>
<%--    <div>--%>
<h2>모달창 제목</h2>
<div id="deliveryForm">
    <c:forEach var="list" items="${list}">
        <div class="dlvAddrList">
            <table>
                <tr>
                    <td>회원번호</td>
                    <td>${list.c_id}</td>
                    <td>배송지주소 고유번호</td>
                    <td>${list.c_adr_list_id}</td>
                    <td>배송지명</td>
                    <td name="rcver" value="${list.rcver}">${list.rcver}</td>
                    <td>배송지명</td>
                    <td>${list.adr_name}</td>
                    <td>연락처</td>
                    <td>${list.rcver_phn}</td>
                    <td>배송지</td>
                    <td>${list.rcver_adr}</td>
                    <td>우편번호</td>
                    <td>${list.rcver_zip}</td>

                    <td><button class="selectDLV" data-c_adr_list_id="${list.c_adr_list_id}">변경</button></td>
                        <%--                            <td><button id="selectDLV" onclick="setSelectedDLV(${list.c_adr_list_id})">변경</button></td>--%>
                </tr>
            </table>
        </div>
    </c:forEach>
</div>
<%--    </div>--%>
<%--</div>--%>

</body>
<script>
    // window.onload = function(){
    $(document).ready(function(){

        var dlvId = <%= request.getParameter("dlvId") %>;

    });

    // "selectAll" 버튼 클릭 시 데이터 요청
    $('#selectAllBtn').click(function(event) {
        // event.preventDefault(); // 버튼의 기본 동작 막기
        // setAllList 함수 호출
        setAllList();
    })

    // "selectDLV" 버튼 클릭시 데이터 전송
    $('.selectDLV').click(function(event) {
        // event.preventDefault(); // 버튼의 기본 동작 막기
        // 클릭된 버튼의 data-c_adr_list_id 속성값 가져오기
        var c_adr_list_id = $(this).data('c_adr_list_id');
        setSelectedDLV(c_adr_list_id);
    });


    // setAllList 함수 정의
    function setAllList() {
        // AJAX를 사용하여 서버로 데이터 요청
        $.ajax({
            type: "GET",
            url: '<%= request.getContextPath() %>/delivery/deliveryList',
            data: {
                c_id: '<%= session.getAttribute("c_id") %>' // 세션에서 c_id 값을 가져옴
            },
            success: function(response) {
                // 받아온 데이터를 deliveryForm 의 HTML에 채워 넣음
                $("#deliveryForm").html(response);
                // $(".modal").attr("style", "display:flex");
            },
            error: function(xhr, status, error) {
                console.error(error);
            }
        });
    }

    // setSelectedDLV 함수 정의
    function setSelectedDLV(c_adr_list_id) {
        $.ajax({
            type: "GET",   // DATA를 서버로 전송
            /* url : 로 컨트롤러로 보낸다. */
            url: '<%= request.getContextPath() %>/delivery/deliverySelected',
            data: {
                dlvId: c_adr_list_id // 값을 넣음
            },
            success: function(response) {
                // 받아온 데이터를 selectedDLV 의 HTML에 채워 넣음
                $("#selectedDLV").html(response);
                console.log("호출이 안됨");
                // 페이지 이동
                <%--window.location.href = '<%= request.getContextPath() %>/delivery/deliveryList?dlvId=' + c_adr_list_id;--%>
            },
            error: function(xhr, status, error) {
                console.error(error);
            }

        });
    }

</script>
</html>