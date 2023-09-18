package com.example.api_student_webapp.Controllers;

import com.example.api_student_webapp.dto.studentDto;
import com.example.api_student_webapp.models.classEntity;
import com.example.api_student_webapp.models.studentEntity;
import com.example.api_student_webapp.service.classService;
import com.example.api_student_webapp.service.studentService;
import com.example.api_student_webapp.studentRepositories.classRepository;
import com.example.api_student_webapp.studentRepositories.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@CrossOrigin
@Controller
public class StudentController {
    @Autowired
    studentService studentService;

    @Autowired
    classService classService;
    @Autowired
    studentRepository studentRepository;
    @Autowired
    classRepository classRepository;

    @GetMapping(value = "/student")
    public String getAllStudent(Model model) {
        List<studentEntity> students = studentRepository.findAll();
        model.addAttribute("student",students);
        return "student/index";
    }
    @GetMapping(value = "/student/add")
    public String createNewStudent(Model model){
        List<classEntity> classAll = classRepository.findAll();
        model.addAttribute("student", new studentEntity());
        model.addAttribute("class",classAll);
        return "student/add";
    }

    @PostMapping(value = "/student/save")
    public String saveStudent(studentDto studentDto){
        studentService.save(studentDto);
        return "redirect:/student";
    }


    @RequestMapping(value = "student/update/{studentId}",method = RequestMethod.GET)
    public String updateStudent(@PathVariable("studentId") int studentId, Model model){
        Optional<studentEntity> result = studentRepository.findById(studentId);
        model.addAttribute("student", result);
        List<classEntity> classAll = classRepository.findAll();
        model.addAttribute("class",classAll);
        return "student/update" ;
    }

    @RequestMapping(value = "/student/delete/{studentId}", method = RequestMethod.GET )
    public String deleteStudent(@PathVariable("studentId")int studentId){
        studentService.deleteById(studentId);
        return "redirect:/student";
    }

    @RequestMapping(value = "/students/{studentId}",method = RequestMethod.GET)
    public Optional<studentEntity> doView(@PathVariable("studentId") int studentId){
        return studentRepository.findById(studentId);
    }


//    @RequestMapping( value = "/student")
//    public ModelAndView doHome(@ModelAttribute("studentModel") studentDto studentDto, Pageable pageable) {
//        ModelAndView mv = new ModelAndView("Student/index");
//        studentMapDto result = studentService.search(studentDto,pageable);
//        List<classDto> depart = classService.getAll();
//        mv.addObject("student", result.getDtoList());
//        mv.addObject("totalItems",result.getNumberOfItems());
//        mv.addObject("class", depart);
//
//        return mv;
//    }
//
//    @RequestMapping(value = "/Employee/create")
//    public ModelAndView doCreate(){
//        ModelAndView mv = new ModelAndView("Employee/add");
//        return mv;
//    }
//
//    @RequestMapping(value = "/Employee/view/{empId}",method = RequestMethod.GET)
//    public ModelAndView doView(@PathVariable("empId") int empId) {
//        ModelAndView mv = new ModelAndView("Employee/view");
//        Optional<EmployeeDto> emp = employeeService.findById(empId);
//        if (emp.isPresent()){
//            mv.addObject("employee", emp.get());
//        }else{
//            System.out.println("nothing id here");
//        }
//        return mv;
//    }
//
//    @RequestMapping(value ="/Employee/save",method = RequestMethod.POST)
//    public ModelAndView doSave(@RequestParam("emp_name") String emp_name,
//                               @RequestParam("age")String age, @RequestParam("sex") String sex,
//                               @RequestParam("birthday") String birthday, @RequestParam("departId") String departId) throws ParseException {
//        ModelAndView mv = new ModelAndView("redirect:/emp");
//
//        Employee employee = new Employee();
//        employee.setEmpName(emp_name);
//        employee.setAge(Integer.parseInt(age));
//        employee.setSex(Integer.parseInt(sex));
//        SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd");
//        employee.setBirthday(frm.parse(birthday));
//        employee.setDepartId(Integer.parseInt(departId));
//        employeeRepo.save(employee);
//
//
//        return mv;
//    }
//
//    @RequestMapping(value = "/Employee/edit/{empId}", method = RequestMethod.GET)
//    public ModelAndView showUpdate(@PathVariable("empId") int empId){
//        ModelAndView mv = new ModelAndView("Employee/edit");
//        List<DepartmentDto> depart = departmentService.getAll();
//        mv.addObject("department", depart);
//        Optional<EmployeeDto> emp = employeeService.findById(empId);
//        mv.addObject("employee", emp.get());
//        return mv;
//    }
//
//    @RequestMapping(value ="/Employee/update",method = RequestMethod.POST)
//    public ModelAndView doUpdate(@RequestParam("emp_id") String emp_id,@RequestParam("emp_name") String emp_name,
//                                 @RequestParam("age")String age, @RequestParam("sex") String sex,
//                                 @RequestParam("birthday") String birthday, @RequestParam("departId") String departId) throws ParseException {
//        ModelAndView mv = new ModelAndView("redirect:/emp");
//        Employee employee = new Employee();
//        employee.setEmpId(Integer.parseInt(emp_id));
//        employee.setEmpName(emp_name);
//        employee.setAge(Integer.parseInt(age));
//        employee.setSex(Integer.parseInt(sex));
//        SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd");
//        employee.setBirthday(frm.parse(birthday));
//        employee.setDepartId(Integer.parseInt(departId));
//        employeeRepo.save(employee);
//        return mv;
//
//    }
//
//
//    @RequestMapping(value = "/Employee/delete/{empId}", method = RequestMethod.GET)
//    public ModelAndView doDelete(@PathVariable("empId") int empId){
//        ModelAndView mv = new ModelAndView("redirect:/emp");
//        employeeService.deleteById(empId);
//        return mv;
//    }
}

