package football.manager.controller;

import football.manager.dto.TransferRequestDto;
import football.manager.dto.TransferResponseDto;
import football.manager.mapper.TransferMapper;
import football.manager.model.Transfer;
import football.manager.service.TransferService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {
    private final TransferService transferService;
    private final TransferMapper transferMapper;

    public TransferController(TransferService transferService,
                              TransferMapper transferMapper) {
        this.transferService = transferService;
        this.transferMapper = transferMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransferResponseDto save(@RequestBody @Valid TransferRequestDto requestDto) {
        Transfer transfer = transferMapper.toModel(requestDto);
        return transferMapper.toDto(transferService.createTransfer(transfer));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransferResponseDto get(@PathVariable Long id) {
        return transferMapper.toDto(transferService.get(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransferResponseDto> getAll() {
        return transferService.getAll().stream()
                .map(transferMapper::toDto)
                .collect(Collectors.toList());
    }
}
