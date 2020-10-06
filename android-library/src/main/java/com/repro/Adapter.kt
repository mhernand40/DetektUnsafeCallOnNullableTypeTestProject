package com.repro

class Adapter {
    fun toPerson(javaUser: JavaUser): Person {
        return Person(name = javaUser.name!!)
    }

    fun toPerson(kotlinUser: KotlinUser): Person {
        return Person(name = kotlinUser.name!!)
    }
}
