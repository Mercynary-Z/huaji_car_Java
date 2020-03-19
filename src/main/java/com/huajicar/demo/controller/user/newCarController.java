package com.huajicar.demo.controller.user;

import com.huajicar.demo.entity.Car;
import com.huajicar.demo.entity.User;
import com.huajicar.demo.service.AgentService;
import com.huajicar.demo.service.CarService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

@Controller
public class newCarController {
    @Autowired
    private AgentService agentService;

    @Autowired
    private CarService carService;

    @GetMapping("/NewCar")
    String newCar(Model model, HttpSession httpSession){
        if(httpSession.getAttribute("user")==null){
            return "redirect:Login";
        }
        model.addAttribute("agents",agentService.getAllAgentName());
        return "user/Car-Info";
    }

    @PostMapping("/NewCar")
    String addCar(Car car, @RequestParam("agent_name")String agent_name, @RequestParam("files") MultipartFile[] files, HttpSession httpSession){
        if(files!=null){
            User user=(User)httpSession.getAttribute("user");
            car.setUser_account(user.getUser_account());
            car.setAgent_id(agentService.getIdByName(agent_name));
            int id=carService.addNewCar(car);

            StringBuffer sb = new StringBuffer();

            for(int i=0;i<files.length;i++){
                String type=files[i].getOriginalFilename().substring(files[i].getOriginalFilename().indexOf("."));
                String filename="car-"+id+"-"+(i+1)+type;

                sb.append("/static/image/"+filename+";");
                String path="./src/main/resources/static/image/"+filename;
                File destFile=new File(path);
                try{
                    FileUtils.copyInputStreamToFile(files[i].getInputStream(),destFile);
                }catch (IOException e){
                    e.printStackTrace();
                }
                path="./target/classes/static/image/"+filename;
                destFile=new File(path);
                try{
                    FileUtils.copyInputStreamToFile(files[i].getInputStream(),destFile);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            carService.updateCarImg(sb.toString(),id);
            return "redirect:PropertyDetail?id="+id;
        }
        return "redirect:NewCar";
    }
}
