package br.com.alura.forum.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {
    @RequestMapping("/")
    @ResponseBody
    fun index() = "Bem vindo ao fórum da Alura"
}