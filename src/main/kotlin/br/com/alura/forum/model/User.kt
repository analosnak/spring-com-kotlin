package br.com.alura.forum.model

import javax.persistence.*

@Table(name="`user`")
@Entity
class User(
        val name: String,
        @Column(nullable = false, unique = true) val email: String,
        val password: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}