package br.com.alura.forum.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HomeController {
    @RequestMapping("/")
    fun index(): String {
        print("Log do servidor de que foi feita uma requisição para '/'.")
        return "Bem vindo ao fórum da Alura"
    }
}