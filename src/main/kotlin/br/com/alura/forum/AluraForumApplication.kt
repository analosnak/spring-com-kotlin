package br.com.alura.forum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.web.config.EnableSpringDataWebSupport

@SpringBootApplication
@EnableSpringDataWebSupport
class AluraForumApplication

fun main(args: Array<String>) {
	runApplication<AluraForumApplication>(*args)
}
