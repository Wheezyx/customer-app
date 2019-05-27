package pl.wedel.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @GetMapping("/")
    public String home()
    {
        rabbitTemplate.convertAndSend("TEST");
        return "index";
    }
}
