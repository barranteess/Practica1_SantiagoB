/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica01.controller;

import com.practica01.domain.Suculenta;
import com.practica01.service.SuculentaService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/suculenta")
public class SuculentaController {

    private final SuculentaService suculentaService;
    private final MessageSource messageSource;

    public SuculentaController(SuculentaService suculentaService, MessageSource messageSource) {
        this.suculentaService = suculentaService;
        this.messageSource = messageSource;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Suculenta> suculentas = suculentaService.getSuculentas();
        model.addAttribute("suculentas", suculentas);
        model.addAttribute("totalSuculentas", suculentas.size());
        return "suculenta/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("suculenta", new Suculenta());
        return "suculenta/formulario";
    }

    @GetMapping("/modificar/{idSuculenta}")
    public String modificar(@PathVariable Integer idSuculenta, Model model, RedirectAttributes redirectAttributes) {
        Optional<Suculenta> suculenta = suculentaService.getSuculenta(idSuculenta);
        if (suculenta.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", mensaje("suculenta.error01"));
            return "redirect:/suculenta/listado";
        }
        model.addAttribute("suculenta", suculenta.get());
        return "suculenta/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("suculenta") Suculenta suculenta,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "suculenta/formulario";
        }
        suculentaService.save(suculenta);
        redirectAttributes.addFlashAttribute("todoOk", mensaje("mensaje.guardado"));
        return "redirect:/suculenta/listado";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer idSuculenta, RedirectAttributes redirectAttributes) {
        try {
            suculentaService.delete(idSuculenta);
            redirectAttributes.addFlashAttribute("todoOk", mensaje("mensaje.eliminado"));
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", mensaje("suculenta.error01"));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", mensaje("suculenta.error02"));
        }
        return "redirect:/suculenta/listado";
    }

    private String mensaje(String llave) {
        return messageSource.getMessage(llave, null, LocaleContextHolder.getLocale());
    }
}