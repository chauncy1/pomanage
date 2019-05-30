package com.capgemini.controller;


import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.capgemini.dto.request.ConInfoSaveRequest;
import com.capgemini.dto.request.PoSaveRequest;
import com.capgemini.dto.request.ProjectSaveRequest;
import com.capgemini.dto.request.RoleInfoSaveRequest;
import com.capgemini.dto.response.CommonResponse;
import com.capgemini.dto.response.ConInfoQueryResponse;
import com.capgemini.dto.response.PoQueryResponse;
import com.capgemini.dto.response.RoleInfoQueryResponse;
import com.capgemini.service.ConInfoService;
import com.capgemini.service.PoInfoService;
import com.capgemini.service.ProjectInfoService;
import com.capgemini.service.RoleInfoService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/adminController")
public class AdminRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminRestController.class);

    @Autowired
    private ProjectInfoService projectInfoService;

    @Autowired
    private PoInfoService poInfoService;

    @Autowired
    private RoleInfoService roleInfoService;

    @Autowired
    private ConInfoService conInfoService;

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public String export(@RequestParam(value = "id") Integer id, HttpServletRequest request) {
//        System.out.println("id = " + id);
        request.getSession().setAttribute("poExportId",id);
        return "success";
    }

    //  导出一个PO信息
    @RequestMapping(value = "/exportPoById", method = RequestMethod.GET)
    public String exportPoById(HttpServletRequest request, HttpServletResponse response){
//    public String exportPoById(@RequestParam(value = "id") Integer id, HttpServletResponse response){

//     String poExportIdString = request.getSession().getAttribute("poExportId").toString();
        Integer poExportId = Integer.parseInt(request.getSession().getAttribute("poExportId").toString());

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + "text_file");

        try {
            XWPFDocument document = poInfoService.exportPoInfo(poExportId);
//            InputStream inputStream = new FileInputStream("C:/Users/yliu12/Desktop/po_template.docx");
//            XWPFDocument document = new XWPFDocument(inputStream);
//            System.out.println(document.getTables().get(0).getRow(1).getCell(0).getText());

            OutputStream outputStream = response.getOutputStream();
            document.write(outputStream);
//            outputStream.write(document);
//            int byteRead;
//            byte[] buffer = new byte[512];
//            while ((byteRead = document.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, byteRead);
//            }
            outputStream.flush();
            outputStream.close();
//            inputStream.close();
            System.out.println("#################################");
            return "success";
        } catch (Exception e) {
            System.out.println("+++++++++++++++++++++++++++++++++");
            return "success";
        }

//        try {
//            ServletOutputStream out=response.getOutputStream();
//            InputStream inputStream = new FileInputStream("C:/Users/yliu12/Desktop/po_template.docx");
//            int len=0;
//            byte[] buffer=new byte[1024];
//            while((len=inputStream.read(buffer))>0){
//                out.write(buffer,0,len);
//            }
//            inputStream.close();
//            out.close();
//        }catch (Exception e){
//            System.out.println("niubi");
//        }

//        CommonResponse commonResponse = new CommonResponse();
//        commonResponse.setCode("200000");
//        commonResponse.setMsg("Export successful!");
//        return commonResponse;

    }

    //  新建一个PROJECT信息(主体部分)
    @RequestMapping(value = "/save_project_info", method = RequestMethod.POST)
    public CommonResponse saveProjectInfo(@RequestBody ProjectSaveRequest request){

        return projectInfoService.saveProjectInfo(request);

    }
    
    //  删除Project(根据 项目ID)
    @RequestMapping(value = "/deleteProjectById", method = RequestMethod.GET)
    public CommonResponse deleteProjectById(@RequestParam(value = "id") Integer id){

        return projectInfoService.deleteProjectById(id);

    }

    //  更新PROJECT信息(根据 项目ID)
    @RequestMapping(value = "/updateProjectByCode", method = RequestMethod.POST)
    public CommonResponse updateProjectInfo(@RequestBody ProjectSaveRequest request){

        return projectInfoService.updateProjectInfo(request);

    }
    
    //  新建一个PO信息(主体部分)
    @RequestMapping(value = "/save_po_info", method = RequestMethod.POST)
    public CommonResponse savePoInfo(@RequestBody PoSaveRequest request){

        return poInfoService.savePoInfo(request);

    }

    //  查询PO信息
    @RequestMapping(value = "/queryPoByCode", method = RequestMethod.GET)
    public PoQueryResponse queryPoByCode(@RequestParam(value = "code") String code){

        return poInfoService.queryPoByCode(code);

    }
    
    //  删除PO(根据 PO_ID)
    @RequestMapping(value = "/deletePoById", method = RequestMethod.GET)
    public CommonResponse deletePoById(@RequestParam(value = "id") Integer id){

        return poInfoService.deletePoById(id);

    }
    
//  更新PO信息(根据 项目ID)
    @RequestMapping(value = "/updatePoByPoNo", method = RequestMethod.POST)
    public CommonResponse updatePoInfo(@RequestBody PoSaveRequest request){

        return poInfoService.updatePoInfo(request);

    }
    


    //  查询Role详情(根据 Role ID)
    @RequestMapping(value = "/queryRoleInfoByPoId", method = RequestMethod.GET)
    public RoleInfoQueryResponse queryRoleInfoByPoId(@RequestParam(value = "po_id") Integer poId){

        return roleInfoService.queryRoleInfoByPoId(poId);

    }
    
    //  新建一个Role信息(详情部分)
    @RequestMapping(value = "/save_role_info", method = RequestMethod.POST)
    public CommonResponse saveRoleInfo(
            @RequestBody RoleInfoSaveRequest request
    ){

        return roleInfoService.saveRoleInfo(request);

    }

    //  查询role详情(根据 详情ID)
    @RequestMapping(value = "/queryRoleInfoById", method = RequestMethod.GET)
    public RoleInfoQueryResponse queryRoleInfoById(@RequestParam(value = "id") Integer id){

        return roleInfoService.queryRoleInfoById(id);

    }

    //  删除Role详情(根据 ROLE_ID)
    @RequestMapping(value = "/deleteRoleInfoById", method = RequestMethod.GET)
    public CommonResponse deleteRoleInfoById(@RequestParam(value = "id") Integer id){

        return roleInfoService.deleteRoleInfoById(id);

    }
    
    //  更新Role详情信息(根据 Role详情ID)
    @RequestMapping(value = "/updateRoleInfoById", method = RequestMethod.POST)
    public CommonResponse updateRoleInfoById(@RequestBody RoleInfoSaveRequest request){

        return roleInfoService.updateRoleInfoById(request);

    }
    
    //  更新consul详情信息(根据 consultant详情ID)
    @RequestMapping(value = "/updateConInfoById", method = RequestMethod.POST)
    public CommonResponse updateConInfoById(@RequestBody ConInfoSaveRequest request){

        return conInfoService.updateConInfoById(request);

    }

    //  删除Consultant详情(根据 CONSULTANT_ID)
    @RequestMapping(value = "/deleteConInfoById", method = RequestMethod.GET)
    public CommonResponse deleteConsultantInfoById(@RequestParam(value = "id") Integer id){

        return conInfoService.deleteConInfoById(id);

    }

    //  新建一个consul信息(详情部分)
    @RequestMapping(value = "/save_con_info", method = RequestMethod.POST)
    public CommonResponse saveConInfo(
            @RequestBody ConInfoSaveRequest request
    ){

        return conInfoService.saveConInfo(request);

    }
    
    @RequestMapping(value = "/queryConInfoByRoleId", method = RequestMethod.GET)
    public ConInfoQueryResponse queryConInfoByRoleId(
    		@RequestParam(value = "role_id") Integer id
    ){

        return conInfoService.queryConInfoByRoleId(id);

    }

    //  更新项目amount详情(基于burneAmount联动更新)信息(根据 项目详情ID)
    /*@RequestMapping(value = "/updateRoleInfoAmountById", method = RequestMethod.GET)
    public CommonResponse updateRoleInfoAmountById(
            @RequestParam(value = "id") Integer id,
            @RequestParam(value = "amount") BigDecimal amount
    ){

        return roleInfoService.updateRoleInfoAmountById(id, amount);

    }*/



}
