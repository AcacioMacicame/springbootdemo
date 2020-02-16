package macicame.org.springbootdemo.controller;

import macicame.org.springbootdemo.model.Province;
import macicame.org.springbootdemo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/")
    public String init(HttpServletRequest request){
        request.setAttribute("provinces", provinceService.findAll());
        request.setAttribute("mode", "PROVINCE_VIEW");
        return "index";
    }

    @GetMapping("/updateProvince")
    public String init(@RequestParam Long id, HttpServletRequest request){
        request.setAttribute("province", provinceService.findById(id));
        request.setAttribute("mode", "PROVINCE_EDIT");
        return "index";
    }

    @PostMapping("/save")
    public void save(@ModelAttribute Province province, HttpServletRequest request, HttpServletResponse response) throws IOException{
        provinceService.save(province);
        request.setAttribute("provinces", provinceService.findAll());
        request.setAttribute("mode", "PROVINCE_VIEW");
        response.sendRedirect("/");
    }

    @GetMapping("/newProvince")
    public String newProvince(HttpServletRequest request){
        request.setAttribute("mode", "PROVINCE_NEW");
        return "index";
    }

    @GetMapping("/deleteProvince")
    public void delete(@RequestParam Long id, HttpServletResponse response) throws IOException{
        provinceService.deleteById(id);
        response.sendRedirect("/");
    }
}
