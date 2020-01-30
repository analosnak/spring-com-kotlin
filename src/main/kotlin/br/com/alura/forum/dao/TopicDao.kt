package br.com.alura.forum.dao

import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class TopicDao (@PersistenceContext private val em: EntityManager) {
    fun save(topic: Topic) = em.persist(topic)

    fun findById(id: Long) = em.find(Topic::class.java, id)

    fun findAll() = em.createQuery("select t from Topic t", Topic::class.java).resultList
}