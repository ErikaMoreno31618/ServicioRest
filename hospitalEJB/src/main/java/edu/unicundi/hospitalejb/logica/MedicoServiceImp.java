package edu.unicundi.hospitalejb.logica;

import edu.unicundi.hospitalejb.entity.Medico;
import edu.unicundi.hospitalejb.exception.BadRequestException;
import edu.unicundi.hospitalejb.exception.IntegridadException;
import edu.unicundi.hospitalejb.exception.NoContentException;
import edu.unicundi.hospitalejb.exception.NotFoundObjectException;
import edu.unicundi.hospitalejb.interfaces.IMedicoService;
import edu.unicundi.hospitalejb.repositoryimp.MedicoRepoImp;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.NotAllowedException;

/**
 * @author Erika Moreno
 * @author Anderson Nevao
 * @since  25/04/2021 
 * @version 1.0.0
 */
@Stateless
public class MedicoServiceImp implements IMedicoService {

    @EJB
    private MedicoRepoImp repo;

    @Override
    public List<Medico> listar() throws NoContentException, NotAllowedException {
        List<Medico> medico = new ArrayList();
        medico = repo.listar();
        if (medico.size() > 0) {
            return medico;
        } else {
            throw new NoContentException("La lista se encuentra vacia");
        }
    }

    @Override
    public Medico BuscarPorId(Integer id) throws NoContentException, NotAllowedException, NotFoundObjectException {
        Medico medico = repo.buscarporId(id);
        return medico;
    }

    @Override
    public void guardar(Medico medico) throws IntegridadException, BadRequestException, NotAllowedException {
        medico.getDireccion().setMedico(medico);
        repo.guardar(medico);
    }

    @Override
    public void eliminar(Integer idMedico) throws NotFoundObjectException, NotAllowedException {
        Medico medico = repo.buscarporId(idMedico);
        if (medico != null) {
            repo.eliminar(medico);
        } else {
            throw new NotFoundObjectException("medico no encontrado");
        }

    }

    @Override
    public void editar(Medico medico) throws IntegridadException, NotFoundObjectException, BadRequestException, NotAllowedException {
        if (medico.getId() == null) {

        }
        Medico ValidarMedico = repo.buscarporId(medico.getId());
        ValidarMedico.setNombre(medico.getNombre());
        ValidarMedico.setApellido(medico.getApellido());
        ValidarMedico.setCorreo(medico.getCorreo());
        ValidarMedico.setFechaNacimiento(medico.getFechaNacimiento());
        if (medico.getDireccion() != null) {
            ValidarMedico.getDireccion().setBarrio(medico.getDireccion().getBarrio());
            ValidarMedico.getDireccion().setCodigoPostal(medico.getDireccion().getCodigoPostal());
        }

        repo.editar(ValidarMedico);

    }

    @Override
    public Medico buscarMedico(int id) {
        Medico medico = repo.buscarporId(id);
        return medico;
    }

}
