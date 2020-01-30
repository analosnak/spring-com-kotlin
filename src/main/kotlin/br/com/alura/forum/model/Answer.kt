package br.com.alura.forum.model

import java.time.Instant
import javax.persistence.*

@Entity
class Answer(
        @Lob val content: String,
        @ManyToOne val topic: Topic,
        @ManyToOne val owner: User
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    val creationInstant = Instant.now()

    var isSolution = false
        private set
}