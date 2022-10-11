package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

     // lives at /hello/hello
    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(value= "hello", method = {RequestMethod.POST, RequestMethod.GET})
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if(name == null) {
            name = "World";
        }

        return createMessage(name, language);
    }

    // Handles requests of the form /hello/nameParam
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello " + name + "!";
    }

    // lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + // submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language' id='language-select'>" +
                "<option value=''>--Choose Language--" +
                "</option>" +
                "<option value='english' selected>English" +
                "</option>" +
                "<option value='spanish'>Spanish" +
                "</option>" +
                "<option value='french'>French" +
                "</option>" +
                "<option value='german'>German" +
                "</option>" +
                "<option value='italian'>Italian" +
                "</option>" +
                "<option value='russian'>Russian" +
                "</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if(l.equals("english")) {
            greeting = "Hello";
        } else if(l.equals("spanish")) {
            greeting = "Hola";
        } else if(l.equals("french")) {
            greeting = "Bonjour";
        } else if(l.equals("german")) {
            greeting = "Hallo";
        } else if(l.equals("italian")) {
            greeting = "Bonjourno";
        } else if(l.equals("russian")) {
            greeting = "Privet";
        }

        return greeting + " " + n;
    }
}
