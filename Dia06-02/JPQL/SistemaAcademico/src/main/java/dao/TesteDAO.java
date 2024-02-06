package dao;

import academico.Curso;
import academico.Estudante;
import dto.EstudanteDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;

public class TesteDAO {

    public static void preparaBD(EntityManager em){

        Curso c1 = new Curso(null, "Matemática", 8);
        Curso c2 = new Curso(null, "Computação", 10);
        Curso c3 = new Curso(null, "Matemática", 8);

        Estudante e1 = new Estudante(null, c1, "Tõe", "toe@tutu", "111111");
        Estudante e2 = new Estudante(null, c1, "Lia", "lia@tutu", "222222");
        Estudante e3 = new Estudante(null, c1, "Tuca", "tuca@tutu", "333333");
        Estudante e4 = new Estudante(null, c2, "Peu", "peu@tutu", "444444");
        Estudante e5 = new Estudante(null, c2, "Leo", "leo@tutu", "555555");
        Estudante e6 = new Estudante(null, c3, "Val", "val@tutu", "666666");

        em.getTransaction().begin();
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        em.persist(e4);
        em.persist(e5);
        em.persist(e6);
        em.getTransaction().commit();

    }

    public static void listarTodosEstudantes(EntityManager em) {
        String jpql = "select e from Estudante e";
        TypedQuery<Estudante> typedQuery =
                em.createQuery(jpql, Estudante.class);
        List<Estudante> lista = typedQuery.getResultList();
        for (Estudante e:lista)
            System.out.println(e.getNome());
    }

    public static void alterarEstudante(EntityManager em){
        String jpql = " select e from Estudante e where Id=1 ";
        TypedQuery<Estudante> typedQuery =
                em.createQuery(jpql, Estudante.class);
        Estudante e = typedQuery.getSingleResult();
        System.out.println(e.getEmail());
        em.getTransaction().begin();
        e.setEmail("totonho@tutu");
        System.out.print("Mudou email : ");
        System.out.println(e.getEmail());
        em.persist(e);
        em.getTransaction().commit();
    }

    public static void gerarEstudanteDTO(EntityManager em) {
        String jpql = "select new dto.EstudanteDTO(e.Nome,"
                +"e.Email, e.Matricula, e.Curso.Nome) from Estudante e";
        TypedQuery<EstudanteDTO> typedQuery =
                em.createQuery(jpql, EstudanteDTO.class);
        List<EstudanteDTO> lista = typedQuery.getResultList();
        for (EstudanteDTO e:lista)
            System.out.println(e.getNome());
    }

    public static void mostrarEstudantesPorCurso(EntityManager em){
        String jpql = "select c from Curso c where c.Id = 1";
        TypedQuery<Curso> typedQuery =
                em.createQuery(jpql, Curso.class);
        Curso c = typedQuery.getSingleResult();
        String jpqlEstudante = "select e from Estudante "
                + "e where e.Curso = :curso";
        TypedQuery<Estudante> typedQueryEstudante =
                em.createQuery(jpqlEstudante, Estudante.class);
        typedQueryEstudante.setParameter("curso", c);
        List<Estudante> lista = typedQueryEstudante.getResultList();
        for (Estudante e: lista)
            System.out.println(e.getNome());
    }

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("unit_academico");

        EntityManager em = emf.createEntityManager();
        TesteDAO.preparaBD(em);

        TesteDAO.listarTodosEstudantes(em);

        TesteDAO.alterarEstudante(em);

        TesteDAO.gerarEstudanteDTO(em);

        System.out.println("BD Recriado");

        TesteDAO.mostrarEstudantesPorCurso(em);



    }

}
