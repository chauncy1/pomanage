package com.capgemini.controller;


import com.capgemini.dto.*;
import com.capgemini.service.ConInfoService;
import com.capgemini.service.PoInfoService;
import com.capgemini.service.ProjectInfoService;
import com.capgemini.service.RoleInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminViewController {

    @Autowired
    private ProjectInfoService projectInfoService;

    @Autowired
    private PoInfoService poInfoService;

    @Autowired
    private RoleInfoService roleInfoService;

    @Autowired
    private ConInfoService conInfoService;

    @RequestMapping("/")
    public String index(@RequestParam(value = "index", required = false) Integer index, Model model, HttpServletRequest request) {
        List<ProjectInfoDto> userList = projectInfoService.viewProject();
        List<ExpiringPoInfoDto> expiringPoInfoDtoList = poInfoService.listExpiringPo();
        model.addAttribute("expiringPoInfos", expiringPoInfoDtoList);
        model.addAttribute("projectinfos", userList);

        // 获取session
//        HttpSession session = request.getSession();

        // 获取工程目录
//        String projectPath = session.getServletContext().getRealPath("/").replaceAll("\\\\", "/");
//        if (!projectPath.endsWith("/")) {
//            projectPath += "/";
//        }
//        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath().replaceAll("\\\\", "/");
//        if (!path.endsWith("/")) {
//            path += "/";
//        }
//        System.out.println(path);

        return "th_ProjectInfo";
    }

    @RequestMapping("/PoInfo")
    public String listPoInfo(@RequestParam(value = "code", required = false) String code,Model model) {
        List<PoInfoDto> userList = poInfoService.viewPoByCode(code);

        ProjectInfoDto projectInfoDto = projectInfoService.queryProjectByCode(code);

        model.addAttribute("poinfos", userList);
        model.addAttribute("projectinfo", projectInfoDto);

        return "th_PoInfo";
    }

    @RequestMapping("/Projectinfo_edit")
    public String projectinfoEdit(@RequestParam(value = "id", required = false) Integer projectId, Model model) {

        ProjectInfoDto projectInfoDto = projectInfoService.queryProjectById(projectId);

        model.addAttribute("projectInfo", projectInfoDto);
        return "th_ProjectInfo_edit";
    }

    @RequestMapping("/Poinfo_edit")
    public String poinfoEdit(@RequestParam(value = "po_id", required = false) Integer poId, Model model) {

        PoInfoDto poInfoDto = poInfoService.queryPoById(poId);

        model.addAttribute("poInfo", poInfoDto);
        return "th_PoInfo_edit";
    }

    @RequestMapping("/Roleinfo_edit")
    public String roleinfoEdit(@RequestParam(value = "role_id", required = false) Integer roleId, Model model) {

    	RoleInfoDto roleInfoDto = roleInfoService.viewRoleInfoById(roleId);

        model.addAttribute("RoleInfo", roleInfoDto);
        return "th_RoleInfo_edit";
    }

    @RequestMapping("/RoleInfo")
    public String listRoleInfo(@RequestParam(value = "po_id") Integer poId, Model model) {

        PoInfoDto poInfoDto = poInfoService.queryPoById(poId);
        model.addAttribute("poinfo", poInfoDto);

        List<RoleInfoDto> dtos = roleInfoService.viewRoleInfoByPoId(poId);
        model.addAttribute("roleinfo", dtos);

        ProjectInfoDto projectInfoDto = projectInfoService.queryProjectByCode(poInfoDto.getCode());

        model.addAttribute("projectinfo", projectInfoDto);

        return "th_RoleInfo";
    }

    @RequestMapping("/ConsultantInfo")
    public String listConsultantInfo(@RequestParam(value = "role_id") Integer roleId, Model model) {

        RoleInfoDto roleInfoDto = roleInfoService.viewRoleInfoById(roleId);
        model.addAttribute("roleinfo", roleInfoDto);

        PoInfoDto poInfoDto = poInfoService.queryPoById(roleInfoDto.getPoId());
        model.addAttribute("poinfo", poInfoDto);

        ProjectInfoDto projectInfoDto = projectInfoService.queryProjectByCode(poInfoDto.getCode());
        model.addAttribute("projectinfo", projectInfoDto);

        List<ConInfoDto> conInfoDtoList = conInfoService.viewConInfoByRoleId(roleId);
        model.addAttribute("coninfo", conInfoDtoList);

        return "th_ConInfo";
    }

    @RequestMapping("/Coninfo_edit")
    public String consultantinfoEdit(@RequestParam(value = "con_id") Integer coId, Model model) {
        ConInfoDto conInfoDto = conInfoService.viewConInfoById(coId);
        model.addAttribute("coninfo", conInfoDto);
        return "th_ConInfo_edit";
    }

}
