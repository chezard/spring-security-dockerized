package com.example.springsecurity.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "t_users")
data class User @JvmOverloads constructor(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = null,

    val username: String? = null,

    val password: String? = null,

    @Enumerated(EnumType.STRING)
    val role: Role? = null,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    val blogs: List<Blog>? = ArrayList()

)