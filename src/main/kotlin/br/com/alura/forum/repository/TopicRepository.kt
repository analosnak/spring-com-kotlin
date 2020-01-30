package br.com.alura.forum.repository

import br.com.alura.forum.model.Topic
import org.springframework.data.repository.CrudRepository

interface TopicRepository : CrudRepository<Topic, Long>