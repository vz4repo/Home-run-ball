<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: left;
        }
    </style>
    <title>삭제된 제품 목록</title>
    <% String msg = (String) request.getAttribute("msg"); %>
    <% if (msg != null && !msg.isEmpty()) { %>
    <script>
        alert("<%= msg %>");
    </script>
    <% } %>
    <script>
        // 페이지 로딩이 완료되면 실행될 함수
        window.onload = function() {
            // alert 창 제목 변경
            document.title = "관리자 메시지";
        };
    </script>
</head>
<body>
    <jsp:include page="../adminMenu.jsp" flush="false" />
    <h1>진열 제외 제품 목록</h1>
    <table>
        <tr>
            <td colspan="16">[총 ${hiddenProductCount}개]</td>
        </tr>
        <tr>
            <td colspan="16">
                <button type="button" id="restoreProduct">상품 복구</button>
                <button type="button" id="deleteProduct">상품 삭제</button>
            </td>
        </tr>
        <tr>
            <th>선택</th>
            <th class="pd_id">제품ID</th>
            <th class="pd_name">제품명</th>
            <th class="mdl_name">모델명</th>
            <th class="pd_type_cd">제품유형</th>
            <th class="pd_type_det_cd">제품상세유형</th>
            <th class="brd_cd">브랜드</th>
            <th class="mn_img_fn">대표 사진 파일명</th>
            <th class="det_img_fn">상세 사진 파일명</th>
            <th class="sls_strt_dt">판매시작일시</th>
            <th class="pd_chr_cd">제품 특성</th>
            <th class="age_grp_cd">사용 연령대</th>
            <th class="qlt_cd">제품품질</th>
            <th class="pd_is_show">제품노출여부</th>
            <th class="hit_cnt">조회수</th>
            <th class="frst_reg_dt">제품 최초 등록일</th>
        </tr>
        <c:forEach var="hiddenProduct" items="${hiddenProductList}">
            <tr>
                <td><input type="checkbox" name="selectedProduct"></td>
                <td class="pd_id">${hiddenProduct.pd_id}</td>
                <td class="pd_name">${hiddenProduct.pd_name}</td>
                <td class="mdl_name">${hiddenProduct.mdl_name}</td>
                <td class="pd_type_cd">${hiddenProduct.pd_type_cd}</td>
                <td class="pd_type_det_cd">${hiddenProduct.pd_type_det_cd}</td>
                <td class="brd_cd">${hiddenProduct.brd_cd}</td>
                <th class="mn_img_fn">${hiddenProduct.mn_img_fn}</th>
                <th class="det_img_fn">${hiddenProduct.det_img_fn}</th>
                <th class="sls_strt_dt">${hiddenProduct.sls_strt_dt}</th>
                <th class="pd_chr_cd">${hiddenProduct.pd_chr_cd}</th>
                <th class="age_grp_cd">${hiddenProduct.age_grp_cd}</th>
                <th class="qlt_cd">${hiddenProduct.qlt_cd}</th>
                <th class="pd_is_show">${hiddenProduct.pd_is_show}</th>
                <th class="hit_cnt">${hiddenProduct.hit_cnt}</th>
                <th class="frst_reg_dt">${hiddenProduct.frst_reg_dt}</th>
            </tr>
        </c:forEach>
    </table>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script>
        $(document).ready(function() {
            /* restoreProduct을 클릭해서 제품을 다시 진열하면 productList페이지로 이동한다. */
            $("#restoreProduct").on("click", function () {
                /*폼을 동적으로 생성한다.*/
                let form = $('<form action="<c:url value='/admin/product/restoreExcludedProduct/'/>" method="post"></form>');

                /*체크된 제품의 리스트를 저장하기 위해 변수를 선언한다.*/
                let selectedProductList = [];

                /*체크된 제품의 제품ID를 가져와서 폼에 추가한다.*/
                $("input:checkbox[name=selectedProduct]:checked").each(function() {
                    selectedProductList.push($(this).closest('tr').find('.pd_id').text());
                });
                console.log("selectedProductList = "+selectedProductList);

                /* 제품ID를 문자열로 결합하여 폼 데이터에 추가 */
                form.append('<input type="hidden" name="pd_id" value="' + selectedProductList.join(',') + '">');

                /*폼을 body에 추가한다.*/
                $(document.body).append(form);

                /*폼을 전송한다.*/
                form.submit();

                /*폼을 제거한다.*/
                form.remove();
            });

            /* "상품 삭제" 버튼을 클릭해서 제품을 정상적으로 삭제하면 productList페이지로 이동한다. */
            $("#deleteProduct").on("click", function () {
                /*폼을 동적으로 생성한다.*/
                let form = $('<form action="<c:url value='/admin/product/deleteExcludedProduct/'/>" method="post"></form>');

                /*체크된 제품의 리스트를 저장하기 위해 변수를 선언한다.*/
                let selectedProductList = [];

                /*체크된 제품의 제품ID를 가져와서 폼에 추가한다.*/
                $("input:checkbox[name=selectedProduct]:checked").each(function() {
                    selectedProductList.push($(this).closest('tr').find('.pd_id').text());
                });
                console.log("selectedProductList = "+selectedProductList);

                /* 제품ID를 문자열로 결합하여 폼 데이터에 추가 */
                form.append('<input type="hidden" name="pd_id" value="' + selectedProductList.join(',') + '">');

                /*폼을 body에 추가한다.*/
                $(document.body).append(form);

                /*폼을 전송한다.*/
                form.submit();

                /*폼을 제거한다.*/
                form.remove();
            });
        });
    </script>
</body>
</html>