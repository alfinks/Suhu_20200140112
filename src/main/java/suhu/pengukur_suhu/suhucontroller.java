/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suhu.pengukur_suhu;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Maulana Alfiansyah
 */
@Controller
public class suhucontroller {
    private int fahrenheit(int suhucelcius){
        int fahrenheit = (suhucelcius*9/5)+32;
        return fahrenheit;
    }
  
   
    private int kelvin(int suhucelcius){
        int kelvin = (int) (suhucelcius + 273.15);
        return kelvin;
    }
    
    @RequestMapping("/suhu")
    //@ResponseBody
    public String getHasil(HttpServletRequest data, Model datasuhu){
       String getnamasuhu = data.getParameter("namasuhu");
       int getsuhucelcius = Integer.parseInt(data.getParameter("suhucelcius")); 
      
       int fahrenheit = fahrenheit(getsuhucelcius);
       int kelvin = kelvin(getsuhucelcius);
       
       datasuhu.addAttribute("celcius", getsuhucelcius);
       datasuhu.addAttribute("fahrenheit", fahrenheit);
       datasuhu.addAttribute("kelvin", kelvin);
       
       return "viewer";
    }
}
