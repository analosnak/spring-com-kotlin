package br.com.alura.forum.repository

import br.com.alura.forum.model.Topic
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.Repository

interface TopicRepository : Repository<Topic, Long> {
    @Query("select t from Topic t")
    fun list(): List<Topic>
}