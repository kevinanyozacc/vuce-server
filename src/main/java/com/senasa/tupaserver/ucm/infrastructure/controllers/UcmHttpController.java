package com.senasa.tupaserver.ucm.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.senasa.tupaserver.ucm.application.UcmCreateService;
import com.senasa.tupaserver.ucm.domain.dtos.UcmCreateDto;
import com.senasa.tupaserver.ucm.infrastructure.repository.UcmSoapRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/ucm")
public class UcmHttpController {

  @Autowired
  UcmSoapRepository ucmRepository;

  @PostMapping("/upload")
  public String fileUploading(
      @RequestParam("file") MultipartFile file,
      @RequestParam("title") String title,
      @RequestParam("autor") String autor,
      @RequestParam("filename") String filename)
      throws Exception {
    UcmCreateService service = new UcmCreateService(this.ucmRepository);
    UcmCreateDto request = new UcmCreateDto();
    request.setTitle(title);
    request.setAutor(autor);
    request.setFilename(filename);
    request.setBuffer(file.getBytes());
    return service.execute(request);
  }
}
