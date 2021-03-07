package com.example.demo.controllers;

import com.example.demo.models.Post;
import org.springframework.core.style.ToStringCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.DOMStringList;

import java.util.ArrayList;

@Controller
public class SocialMediaController {
    private ArrayList<Post> posts = new ArrayList<>();

    @GetMapping("/Success")
    public String renderSuccess() {
        return "Success.html";
    }

        @PostMapping("/Post-successfully-created")
                public String successPost (@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("visibility") String visibility, @RequestParam("gender") String gender) {
            // simulating new event creation
            Post post = new Post(title, content, visibility, gender);
            return post.title + content + visibility + gender;
    }


    @GetMapping("/submit")
    public String renderEventForm() {
        return "post-form.html";
    }

    @PostMapping("/create-new-post")
    public String createNewEvent(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("visibility") String visibility, @RequestParam("gender") String gender) {
        // simulating new event creation
        Post post = new Post(title, content, visibility, gender);
        posts.add(post);

        return "redirect:/Success";
    }

    @GetMapping("/dashboard")
    @ResponseBody
    public ArrayList renderDashboard() {
        ArrayList<Post> publicPosts = new ArrayList<>();

        for (Post post : posts) {
            if(post.visibility.equals("public")) {
                publicPosts.add(post);
            }
        }

        return publicPosts;
    }
    @GetMapping("/AboutUs")
    public String renderAbout(Model model) {
//        model.addAttribute("");
        return "AboutUs.html";
    }

    @GetMapping("/Contact")
    public String renderContact(Model model) {
//        model.addAttribute("");
        return "Contact.html";

    }
}
