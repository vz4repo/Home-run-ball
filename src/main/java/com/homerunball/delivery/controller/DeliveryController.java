package com.homerunball.delivery.controller;

import com.homerunball.delivery.dao.DeliveryDao;
import com.homerunball.delivery.domain.DeliveryDto;
import com.homerunball.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/delivery") /* 원하는 url을 사용해서 해당 메서드 실행할수있게 해줌 */
public class DeliveryController {
    @Autowired /* 의존성 주입 */
    DeliveryDao deliveryDao;
    @Autowired
    DeliveryService deliveryService;



    /* 유저 개인의 배송지 전체 목록 띄우는 */
    @GetMapping("/deliveryList")
    public String deliveryList(@SessionAttribute(name = "c_id")int sessionId, DeliveryDto dto, Model model) throws Exception {

        /* 기본배송지 무조건 띄워줄 dto */
//        DeliveryDto defaultDto = deliveryService.read(sessionId, 1);
//        model.addAttribute("defaultDto", defaultDto);

        List<DeliveryDto> list = deliveryService.readAll(dto.getC_id());
        model.addAttribute("list", list);

        System.out.println("dto.getC_id() = " + dto.getC_id());
        System.out.println("list = " + list);

        return "deliveryList";
    }


    /* TODO : 원장님이 파라미터에 @RequestParam("dlvId") Integer dlvId 이거 쓰지 마라그랬는데 ㅜㅜ */
    @GetMapping("/deliverySelected")
    public String selectedList(@SessionAttribute(name = "c_id")int sessionId, Model model, DeliveryDto dto, @RequestParam("dlvId") Integer dlvId) throws Exception {
        try {
            /* 선택된 배송지 dto */
            DeliveryDto selectedDto = deliveryService.read(sessionId, dlvId);
            model.addAttribute("selectedDto", selectedDto);
            model.addAttribute("dlvId", dlvId); // dlvId도 모델에 추가
            System.out.println("***** 배송지 띄우기 = " + deliveryService.read(sessionId, dlvId));
            System.out.println("dto = " + dto); // 얘는 null
            System.out.println("selectedDto = " + selectedDto); // 얘는 값들어가있음.
            System.out.println("dto.getC_adr_list_id() = " + dlvId);
            System.out.println("dlvId = " + dlvId);

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*        System.out.println("deliveryDto = " + deliveryDto.toString());*/
        return "deliveryList";
    }

    @GetMapping("/")
    public String selectedDefault(@SessionAttribute(name = "c_id")int sessionId, Model model) throws Exception {
        try {
            DeliveryDto deliveryDto = deliveryDao.selecteDefault(sessionId);
            model.addAttribute("selectedDto", deliveryDto);

            System.out.println("[DeliveryController]selectedDto = " + deliveryDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "deliveryList";
    }


}