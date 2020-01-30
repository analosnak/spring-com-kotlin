package br.com.alura.forum.model

import javax.persistence.*

@Entity
class Course(
        val name: String,
        @ManyToOne val subcategory: Category
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    val categoryName: String
        get() {
            val category = checkNotNull(subcategory.category) { "Esta já é uma categoria mãe" }
            return category.name
        }
}