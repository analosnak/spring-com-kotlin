package br.com.alura.forum.repository

import br.com.alura.forum.model.Topic
import org.springframework.data.repository.Repository

interface TopicRepository : Repository<Topic, Long> {
    fun findAll(): List<Topic>
}