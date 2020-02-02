package pl.sytomczak.randomSentenceGenerator;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {

    private static final String RANDOMSENTENCEGENERATOR_SERVICE_OBJECT_NAME = "service";
    private static final String PAGE_TITLE_CLASS_NAME = "pageTitle";
    private static final String INSTRUCTION_TITLE_CLASS_NAME = "instructionTitle";
    private static final String INSTRUCTION_CONTENTS_CLASS_NAME = "instructionContents";
    private static final String CHECK_BUTTON_NAME_CLASS = "checkSubmit";
    private static final String ADVICE_CLASS_NAME = "selectedSentence";

    private RandomSentenceGeneratorService service;

    @Autowired
    public HomeController(RandomSentenceGeneratorService service) {this.service = service;}

    @GetMapping("/")
    public String showHomePage(Model model) {
        populateStaticContent(model);
        return "home";
    }

    @PostMapping(value = "/callback", params = "action="+StringConstants.CHECK_BUTTON)
    public String choseSentence(Model model) {
        populateStaticContent(model);

        service.generateSentences();
        model.addAttribute("sentence", service.getSelectedSentence());
        return "home";
    }

    private void populateStaticContent(Model model){
        model.addAttribute(PAGE_TITLE_CLASS_NAME, StringConstants.PAGE_TITLE);
        model.addAttribute(INSTRUCTION_TITLE_CLASS_NAME, StringConstants.INSTRUCTION_TITLE);
        model.addAttribute(INSTRUCTION_CONTENTS_CLASS_NAME, StringConstants.INSTRUCTION_CONTENTS);
        model.addAttribute(CHECK_BUTTON_NAME_CLASS, StringConstants.CHECK_BUTTON);
        model.addAttribute(ADVICE_CLASS_NAME, StringConstants.ADVICE_TITLE);

        model.addAttribute(RANDOMSENTENCEGENERATOR_SERVICE_OBJECT_NAME, service);
    }
}
