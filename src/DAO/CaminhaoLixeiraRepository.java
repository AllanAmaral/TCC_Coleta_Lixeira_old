package DAO;

import Business.Objects.CaminhaoLixeira;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

/**
 *
 * @author Allan.Amaral
 */
public class CaminhaoLixeiraRepository implements Serializable {

    public CaminhaoLixeiraRepository() {
        this.emf = Persistence.createEntityManagerFactory("TCC_Coleta_LixoPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void registrar(CaminhaoLixeira caminhaoLixeira) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(caminhaoLixeira);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (buscarCaminhaoLixeira(caminhaoLixeira.getIdCaminhaoLixeira()) != null) {
                throw new Exception("O vínculo entre caminhão e lixeira já existe.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void editar(CaminhaoLixeira caminhaoLixeira) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            caminhaoLixeira = em.merge(caminhaoLixeira);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = caminhaoLixeira.getIdCaminhaoLixeira();
                if (buscarCaminhaoLixeira(id) == null) {
                    throw new Exception("O vínculo entre caminhão e lixeira não existe.");
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
            CaminhaoLixeira caminhaoLixeira;
            try {
                caminhaoLixeira = em.getReference(CaminhaoLixeira.class, id);
                caminhaoLixeira.getIdCaminhaoLixeira();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("O vínculo entre caminhão e lixeira não existe.", enfe);
            }
            em.remove(caminhaoLixeira);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public CaminhaoLixeira buscarCaminhaoLixeira(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CaminhaoLixeira.class, id);
        } finally {
            em.close();
        }
    }
    
    /*
    public List<CaminhaoMotorista> findCaminhaoMotoristaEntities() {
        return findCaminhaoMotoristaEntities(true, -1, -1);
    }

    public List<CaminhaoMotorista> findCaminhaoMotoristaEntities(int maxResults, int firstResult) {
        return findCaminhaoMotoristaEntities(false, maxResults, firstResult);
    }

    private List<CaminhaoMotorista> findCaminhaoMotoristaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CaminhaoMotorista.class));
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

    public int getCaminhaoMotoristaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CaminhaoMotorista> rt = cq.from(CaminhaoMotorista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    */
}