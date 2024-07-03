package com.senasa.tupaserver.ucm.domain.dtos;

public class UcmCreateDto {
  private String title;
  private String autor;
  private String filename;
  private byte[] buffer;

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String value) {
    this.title = value;
  }

  public String getAutor() {
    return this.autor;
  }

  public void setAutor(String value) {
    this.autor = value;
  }

  public String getFilename() {
    return this.filename;
  }

  public void setFilename(String value) {
    this.filename = value;
  }

  public byte[] getBuffer() {
    return this.buffer;
  }

  public void setBuffer(byte[] value) {
    this.buffer = value;
  }
}
