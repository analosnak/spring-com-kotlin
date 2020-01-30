package br.com.alura.forum.model

import javax.persistence.*

@Entity
data class Category(
        val name: String,
        @ManyToOne val category: Category? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @OneToMany(mappedBy = "category")
    private val subcategories = listOf<Category>()

    val subcategoriesNames: List<String> get() = subcategories.map { it.name }
}