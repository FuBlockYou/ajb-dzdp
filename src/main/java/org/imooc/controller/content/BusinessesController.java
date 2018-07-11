package org.imooc.controller.content;


import org.imooc.bean.Business;
import org.imooc.constant.DicTypeConst;
import org.imooc.constant.PageCodeEnum;
import org.imooc.dto.BusinessDto;
import org.imooc.service.BusinessService;
import org.imooc.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/businesses")
public class BusinessesController {
    @Resource
    private DicService dicService;
   @Resource
   private BusinessService businessService;
    /**
     * 商户列表
     * @param dto
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String search(BusinessDto dto, Model model){
        List<BusinessDto> ls = businessService.searchByPage(dto);
        model.addAttribute("list",ls);
        model.addAttribute("searchParam",dto);
        return "/content/businessList";
    }

    /**
     * 删除商户
     * @param id
     * @return
     */
    @RequestMapping(value ="/{id}",method = RequestMethod.DELETE)
    public String remove(@PathVariable("id")Long id){

        return "/content/businessList";
    }


    /**
     * 商户新增页初始化
     * @return
     */
    @RequestMapping(value = "/addPage",method = RequestMethod.GET)
    public String addInit(Model model){
        model.addAttribute("cityList", dicService.getListByType(DicTypeConst.CITY));
        model.addAttribute("categoryList", dicService.getListByType(DicTypeConst.CATEGORY));
        return "/content/businessAdd";

    }

    /**
     * 商户新增
     * @param dto
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String add(BusinessDto dto,RedirectAttributes attr) {
        if(businessService.insertBusiness(dto)) {
            attr.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
            return "redirect:/businesses";
        } else {
            attr.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
            return "redirect:/businesses/addPage";
        }
    }

    /**
     * 用户修改页初始化
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String modifyInit(@PathVariable("id")Long id,Model model){
        //修改页面下拉列表的初始化
        model.addAttribute("cityList", dicService.getListByType(DicTypeConst.CITY));
        model.addAttribute("categoryList", dicService.getListByType(DicTypeConst.CATEGORY));
        //根据ID获取所要修改的基本内容
        model.addAttribute("modifyObj", businessService.selectById(id));
        return "/content/businessModify";
    }

    /**
     * 商户修改
     * @param id
     * @param dto
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String modify(@PathVariable("id")Long id, BusinessDto dto){

        return "/content/businessModify";
    }
}
