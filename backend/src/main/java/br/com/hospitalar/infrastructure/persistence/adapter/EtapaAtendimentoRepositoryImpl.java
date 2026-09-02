package br.com.hospitalar.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;

import br.com.hospitalar.application.ports.out.EtapaAtendimentoRepository;
import br.com.hospitalar.domain.Atendimento;
import br.com.hospitalar.domain.EtapaAtendimento;
import br.com.hospitalar.infrastructure.persistence.mapper.AtendimentoMapper;
import br.com.hospitalar.infrastructure.persistence.mapper.EtapaAtendimentoMapper;
import br.com.hospitalar.infrastructure.persistence.repository.EtapaAtendimentoSpringDataRepository;

public class EtapaAtendimentoRepositoryImpl implements EtapaAtendimentoRepository {
    private final EtapaAtendimentoSpringDataRepository etapaAtendimentoSpringDataRepository;

    public EtapaAtendimentoRepositoryImpl(EtapaAtendimentoSpringDataRepository etapaAtendimentoSpringDataRepository) {
        this.etapaAtendimentoSpringDataRepository = etapaAtendimentoSpringDataRepository;
    }

    @Override
    public EtapaAtendimento salva(EtapaAtendimento etapaAtendimento) {
        return EtapaAtendimentoMapper.toDomain(
            etapaAtendimentoSpringDataRepository.save(EtapaAtendimentoMapper.toEntity(etapaAtendimento))
        );
    }

    @Override
    public Optional<EtapaAtendimento> buscaPorId(Long id) {
        return etapaAtendimentoSpringDataRepository.findById(id)
                .map(EtapaAtendimentoMapper::toDomain);
    }

    @Override
    public List<EtapaAtendimento> buscaPorAtendimento(Atendimento atendimento) {
        return etapaAtendimentoSpringDataRepository.findByAtendimento(AtendimentoMapper.toEntity(atendimento))
                .stream()
                .map(EtapaAtendimentoMapper::toDomain)
                .toList();
    }
    
}
