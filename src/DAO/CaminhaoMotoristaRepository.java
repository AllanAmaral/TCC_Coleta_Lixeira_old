package DAO;

import Business.Objects.CaminhaoMotorista;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

/**
 *
 * @author Allan.Amaral
 */
public class CaminhaoMotoristaRepository implements Serializable {

    public CaminhaoMotoristaRepository() {
        this.emf = Persistence.createEntityManagerFactory("TCC_Coleta_LixoPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void registrar(CaminhaoMotorista caminhaoMotorista) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(caminhaoMotorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (buscarCaminhaoMotorista(caminhaoMotorista.getIdCaminhaoMotorista()) != null) {
                throw new Exception("O vínculo entre caminhão e motorista já existe.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void editar(CaminhaoMotorista caminhaoMotorista) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            caminhaoMotorista = em.merge(caminhaoMotorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = caminhaoMotorista.getIdCaminhaoMotorista();
                if (buscarCaminhaoMotorista(id) == null) {
                    throw new Exception("O vínculo entre caminhão e motorista não existe.");
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
            CaminhaoMotorista caminhaoMotorista;
            try {
                caminhaoMotorista = em.getReference(CaminhaoMotorista.class, id);
                caminhaoMotorista.getIdCaminhaoMotorista();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("O vínculo entre caminhão e motorista não existe.", enfe);
            }
            em.remove(caminhaoMotorista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public CaminhaoMotorista buscarCaminhaoMotorista(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CaminhaoMotorista.class, id);
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
