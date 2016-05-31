package DAO;

import Business.Objects.Motorista;
import Business.Objects.Motorista_;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Allan.Amaral
 */
public class MotoristaRepository extends GenericDAO {

    public void registrar(Motorista motorista) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(motorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (buscarMotorista(motorista.getIdMotorista()) != null) {
                throw new Exception("Motorista já existe", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void editar(Motorista motorista) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            motorista = em.merge(motorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = motorista.getIdMotorista();
                if (buscarMotorista(id) == null) {
                    throw new Exception("O motorista não existe.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void excluir(Integer id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Motorista motorista;
            try {
                motorista = em.getReference(Motorista.class, id);
                motorista.getIdMotorista();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("O motorista não existe.", enfe);
            }
            em.remove(motorista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Motorista buscarMotorista(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Motorista.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<Motorista> buscarMotorista(String nome) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Motorista> cq = em.getCriteriaBuilder().createQuery(Motorista.class);
            Root<Motorista> root = cq.from(Motorista.class);
            cq.select(root);
            cq.where(em.getCriteriaBuilder().like(root.get(Motorista_.nomeMotorista), nome + "%"));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    /*
    public List<Motorista> findMotoristaEntities() {
        return findMotoristaEntities(true, -1, -1);
    }

    public List<Motorista> findMotoristaEntities(int maxResults, int firstResult) {
        return findMotoristaEntities(false, maxResults, firstResult);
    }

    private List<Motorista> findMotoristaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Motorista.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public int getMotoristaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Motorista> rt = cq.from(Motorista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    */
}
