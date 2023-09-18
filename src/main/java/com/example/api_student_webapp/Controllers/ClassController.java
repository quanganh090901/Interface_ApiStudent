package com.example.api_student_webapp.Controllers;

import com.example.api_student_webapp.dto.classDto;
import com.example.api_student_webapp.dto.classMapDto;
import com.example.api_student_webapp.dto.studentDto;
import com.example.api_student_webapp.models.classEntity;
import com.example.api_student_webapp.models.studentEntity;
import com.example.api_student_webapp.service.classService;
import com.example.api_student_webapp.studentRepositories.classRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin
@Controller
public class ClassController {
    @Autowired
    classRepository classRepository;
    @Autowired
    classService classService;
    @GetMapping(value = "/class")
    public String getAllStudent(Model model) {
        List<classEntity> classEntities = classRepository.findAll();
        model.addAttribute("class",classEntities);
        return "student/class/index";
    }
    @GetMapping(value = "/class/add")
    public String createClass(Model model){
        model.addAttribute("class", new classEntity());
        return "student/class/add";
    }
    @PostMapping(value = "/class/save")
    public String saveClass(classDto classDto){
        classService.save(classDto);
        return "redirect:/class";
    }
    @RequestMapping(value = "class/update/{id}",method = RequestMethod.GET)
    public String updateStudent(@PathVariable("id") int id, Model model){
        Optional<classEntity> result = classRepository.findById(id);
        model.addAttribute("class", result);
        return "student/class/update" ;
    }

    @RequestMapping(value = "/class/delete/{id}", method = RequestMethod.GET )
    public String deleteStudent(@PathVariable("id")int id){
        classService.deleteById(id);
        return "redirect:/class";
    }

    @RequestMapping(value = "/class/{id}",method = RequestMethod.GET)
    public Optional<classEntity> doView(@PathVariable("id") int id){
        return classRepository.findById(id);
    }
//
//    @RequestMapping(value = "/home")
//    public ModelAndView index(){
//        ModelAndView mv = new ModelAndView("index");
//        mv.addObject("class", classRepository.findAll());
////        mv.addObject("totalItems", )
//        return mv;
//    }
//    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    public ModelAndView doSearch(@ModelAttribute("classModel") classDto classDto, Pageable pageable, HttpServletRequest request){
//        ModelAndView mv = new ModelAndView("index");
//        //try {
//        // check status delete
//        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
//        if (inputFlashMap != null) {
//            String statusDel = (String) inputFlashMap.get("statusDel");
//            // TODO: convert to switch case
//            if (statusDel.equals("0")) {
//                mv.addObject("msgDel", "xóa thành công ");
//            } else if (statusDel.equals("1")) {
//                mv.addObject("msgDel", "không thể xóa phòng ban này, vui lòng xóa nhân viên trước");
//            } else if (statusDel.equals("2")) {
//                mv.addObject("msgDel","error");
//            }
//        }
//        classMapDto result = classService.search(classDto,pageable);
//        mv.addObject("class",result.getList());
//        mv.addObject("totalItems", result.getNumberOfItems());
//        return mv;
////        }catch (Exception ex){
////            return null;
////        }
//    }
}
