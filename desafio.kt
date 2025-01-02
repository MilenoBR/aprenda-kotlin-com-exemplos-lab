enum class Sexo { MASCULINO, FEMININO }
enum class Nivel {BASICO, INTERMEDIARIO, AVANÇADO}

class Usuario(val nome: String, val sexo: Sexo)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    val conteudos: List<ConteudoEducacional>
) {
    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            val artigo = if (usuario.sexo == Sexo.FEMININO) "a" else "o"
            println("${usuario.nome} já está matriculad${artigo} na formação $nome.")
        } else {
            inscritos.add(usuario)
            val artigo = if (usuario.sexo == Sexo.FEMININO) "a" else "o"
            println("${usuario.nome} foi matriculad${artigo} com sucesso na formação $nome.")
        }
    }

    fun listarInscritos() {
        println("Lista de inscritos na formação $nome:")
        inscritos.forEach { println("- ${it.nome}") }
    }
}

fun main() {
    val usuario1 = Usuario("Mileno", Sexo.MASCULINO)
    val usuario2 = Usuario("Yasmin", Sexo.FEMININO)

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)

    val formacaoKotlin = Formacao(
        nome = "Kotlin Developer",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(conteudo1, conteudo2)
    )

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    formacaoKotlin.listarInscritos()
}