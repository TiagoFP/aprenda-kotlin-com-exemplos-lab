enum class Nivel {
    BASICO, INTERMEDIARIO, AVANCADO
}

class Usuario(val nome: String, val nivel: Nivel)

class ConteudoEducacional(val nome: String, val duracao: String, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {
    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun mostrarInscritos() {
        println("Inscritos na formação $nome:")
        inscritos.forEach { println("- ${it.nome} - nível: ${it.nivel}") }
    }
}

fun main() {
    val conteudos = listOf(
        ConteudoEducacional("Kotlin Básico", "10 Horas", Nivel.BASICO),
        ConteudoEducacional("Kotlin Intermediário", "20 Horas", Nivel.INTERMEDIARIO),
        ConteudoEducacional("Kotlin Avançado", "30 Horas", Nivel.AVANCADO)
    )

    val usuario1 = Usuario("João da Silva", Nivel.INTERMEDIARIO)
    val usuario2 = Usuario("Maria Santana", Nivel.BASICO)
    val usuario3 = Usuario("Vitor Baima", Nivel.AVANCADO)

    val formacao = Formacao("Kotlin", conteudos)
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario3)

    formacao.mostrarInscritos()
}
