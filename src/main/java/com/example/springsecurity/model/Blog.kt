package com.example.springsecurity.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "t_blogs")
data class Blog @JvmOverloads constructor(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = null,

    @ManyToOne
    @JoinColumn(nullable = false)
    val user: User,

    val content: String
) {

}