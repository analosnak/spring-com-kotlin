package br.com.alura.forum.model

import br.com.alura.forum.model.TopicStatus.*
import java.time.Instant
import javax.persistence.*
import javax.persistence.EnumType.STRING
import javax.persistence.GenerationType.IDENTITY

@Entity
class Topic(
        val shortDescription: String,
        @Column(columnDefinition = "text") val content: String,
        @ManyToOne val owner: User,
        @ManyToOne val course: Course
) {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null
    val creationInstant: Instant = Instant.now()
    val lastUpdate: Instant = Instant.now()
    @Enumerated(STRING) var status = NOT_ANSWERED
    @OneToMany(mappedBy = "topic") private val _answers = mutableListOf<Answer>()
    val answers: List<Answer>
        get() = _answers

    fun registerNewReply(newReply: Answer) =
        if (status == CLOSED) {
            throw RuntimeException("Tópico fechado! Não é possível adicionar novas respostas")
        }
        else {
            if (owner == newReply.owner) status = NOT_SOLVED
            _answers += newReply
        }

    fun markAsSolved() =
        if (status == SOLVED || status == CLOSED) throw RuntimeException("A dúvida já está solucionada!")
        else status = SOLVED

    fun close() =
        if (status == CLOSED) throw RuntimeException("Essa dúvida já está fechada!")
        else status = CLOSED

}

enum class TopicStatus { NOT_ANSWERED, NOT_SOLVED, SOLVED, CLOSED }
