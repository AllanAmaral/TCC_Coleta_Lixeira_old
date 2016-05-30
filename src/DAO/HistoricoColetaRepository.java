package DAO;

import Busines.Objects.HistoricoColeta;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author Allan.Amaral
 */
public class HistoricoColetaRepository implements Serializable {

    public HistoricoColetaRepository() {
        this.emf = Persistence.createEntityManagerFactory("TCC_Coleta_LixoPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void registrar(HistoricoColeta historicoColeta) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(historicoColeta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (buscarHistoricoColeta(historicoColeta.getIdHistoricoColeta()) != null) {
                throw new Exception("Histórico da coleta já existe.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void editar(HistoricoColeta historicoColeta) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            historicoColeta = em.merge(historicoColeta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = historicoColeta.getIdHistoricoColeta();
                if (buscarHistoricoColeta(id) == null) {
                    throw new Exception("O histórico da coleta não existe.");
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
            HistoricoColeta historicoColeta;
            try {
                historicoColeta = em.getReference(HistoricoColeta.class, id);
                historicoColeta.getIdHistoricoColeta();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("O histórico da coleta não existe.", enfe);
            }
            em.remove(historicoColeta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public HistoricoColeta buscarHistoricoColeta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistoricoColeta.class, id);
        } finally {
            em.close();
        }
    }
    
    /*
    public List<HistoricoColeta> findHistoricoColetaEntities() {
        return findHistoricoColetaEntities(true, -1, -1);
    }

    public List<HistoricoColeta> findHistoricoColetaEntities(int maxResults, int firstResult) {
        return findHistoricoColetaEntities(false, maxResults, firstResult);
    }

    private List<HistoricoColeta> findHistoricoColetaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistoricoColeta.class));
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

    public int getHistoricoColetaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistoricoColeta> rt = cq.from(HistoricoColeta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    */
}
