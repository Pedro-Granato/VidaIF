package br.edu.ifsp.vidaif.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.vidaif.R
import br.edu.ifsp.vidaif.adapter.CourseCategoryAdapter
import br.edu.ifsp.vidaif.model.Course
import br.edu.ifsp.vidaif.model.CourseCategory

class CoursesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_courses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCourseCategoriesRecyclerView(view)
    }

    private fun setupCourseCategoriesRecyclerView(view: View) {
        val coursesRecyclerView: RecyclerView = view.findViewById(R.id.coursesRecyclerView)
        coursesRecyclerView.layoutManager = LinearLayoutManager(context)

        val categories = mutableListOf<CourseCategory>()

        // TÉCNICO INTEGRADO AO ENSINO MÉDIO
        categories.add(
            CourseCategory(
                categoryName = "🎓 TÉCNICO INTEGRADO AO ENSINO MÉDIO",
                courses = listOf(
                    Course(
                        title = "Mecânica Integrado ao Ensino Médio",
                        info = "Duração: 3 anos • Integral",
                        description = "Formação técnica em Mecânica integrada ao Ensino Médio. Aprenda sobre processos de fabricação, manutenção, projetos mecânicos e muito mais."
                    ),
                    Course(
                        title = "Mecatrônica Integrado ao Ensino Médio",
                        info = "Duração: 3 anos • Integral",
                        description = "Curso técnico que integra Mecânica, Eletrônica e Computação. Forme-se em uma área estratégica da indústria moderna com automação e robótica."
                    ),
                    Course(
                        title = "Química Integrado ao Ensino Médio",
                        info = "Duração: 3 anos • Integral",
                        description = "Formação técnica em Química com Ensino Médio. Desenvolva competências em análises químicas, processos industriais e controle de qualidade."
                    ),
                    Course(
                        title = "Redes de Computadores Integrado ao Ensino Médio",
                        info = "Duração: 3 anos • Integral",
                        description = "Curso técnico focado em infraestrutura de TI e redes. Aprenda sobre instalação, configuração e manutenção de redes de computadores."
                    )
                )
            )
        )

        // CURSOS SUPERIORES
        categories.add(
            CourseCategory(
                categoryName = "🎓 CURSOS SUPERIORES",
                courses = listOf(
                    Course(
                        title = "Análise e Desenvolvimento de Sistemas",
                        info = "Duração: 3 anos • Noturno",
                        description = "Forme-se em uma das áreas mais promissoras do mercado. Desenvolva sistemas, aplicativos e soluções tecnológicas inovadoras.",
                        features = listOf(
                            "Programação e Desenvolvimento Web",
                            "Banco de Dados e Cloud Computing",
                            "Mobile e Inteligência Artificial"
                        )
                    ),
                    Course(
                        title = "Licenciatura em Química",
                        info = "Duração: 4 anos • Noturno",
                        description = "Forme-se para ser um educador transformador na área de Química. Desenvolva competências pedagógicas sólidas e domínio científico para inspirar a próxima geração de cientistas."
                    ),
                    Course(
                        title = "Engenharia de Controle e Automação",
                        info = "Duração: 5 anos • Integral",
                        description = "Torne-se um engenheiro especialista em sistemas automatizados e controle de processos. Domine as tecnologias que movem a Indústria 4.0 e a transformação digital."
                    )
                )
            )
        )

        // PÓS-GRADUAÇÃO
        categories.add(
            CourseCategory(
                categoryName = "📚 PÓS-GRADUAÇÃO LATO SENSU",
                courses = listOf(
                    Course(
                        title = "Internet das Coisas (IoT)",
                        info = "Duração: 3 semestres • Presencial",
                        description = "Especialização em IoT para profissionais que desejam dominar as tecnologias de conectividade, sensores, dispositivos inteligentes e análise de dados."
                    ),
                    Course(
                        title = "Saberes e Práticas para a Docência no Ensino Fundamental I",
                        info = "Duração: 2 semestres • Presencial",
                        description = "Especialização voltada para educadores que atuam ou pretendem atuar no Ensino Fundamental I. Aprofunde conhecimentos pedagógicos e metodologias de ensino."
                    )
                )
            )
        )

        Log.d("CoursesFragment", "Total de categorias: ${categories.size}")
        categories.forEachIndexed { index, category ->
            Log.d("CoursesFragment", "Categoria $index: ${category.categoryName} - ${category.courses.size} cursos")
        }

        coursesRecyclerView.adapter = CourseCategoryAdapter(categories)
    }
}