package br.com.alura.forum.model

import org.hibernate.annotations.Type
import java.time.Instant
import javax.persistence.*

@Entity
class Answer(
    @Lob @Type(type = "org.hibernate.type.TextType") val content: String,
    @ManyToOne val topic: Topic,
    @ManyToOne val owner: User
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    val creationInstant: Instant = Instant.now()
    var isSolution = false
        private set

    fun markAsSolution() {
        isSolution = true
        topic.markAsSolved()
    }
}