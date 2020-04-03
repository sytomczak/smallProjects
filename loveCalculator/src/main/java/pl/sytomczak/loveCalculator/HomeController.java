package pl.sytomczak.loveCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private static final String PAGE_TITLE_CLASS_NAME = "pageTitle";
    private static final String LOVECALCULATOR_SERVICE_OBJECT_NAME = "service";
    private static final String INSTRUCTION_TITLE_CLASS_NAME = "instructionTitle";
    private static final String INSTRUCTION_CONTENTS_CLASS_NAME = "instructionContents";
    private static final String ADVICE_TITLE_CLASS_NAME = "adviceTitle";
    private static final String ADVICE_CONTENTS_CLASS_NAME = "adviceContents";
    private static final String INPUT_MALE_NAME_LABEL_CLASS_NAME = "inputMaleNameLabel";
    private static final String INPUT_FEMALE_NAME_LABEL_CLASS_NAME = "inputFemaleNameLabel";
    private static final String INPUT_MALE_NAME_PLACEHOLDER_NAME_CLASS = "inputMaleNamePlaceholder";
    private static final String INPUT_FEMALE_NAME_PLACEHOLDER_NAME_CLASS = "inputFemaleNamePlaceholder";
    private static final String CHECK_BUTTON_NAME_CLASS = "checkSubmit";
    private static final String DISCLAIMER_CONTENTS_NAME_CLASS = "disclaimerContents";
    private static final String DISCLAIMER_TITLE_NAME_CLASS = "disclaimerTitle";
    private static final String CLOSE_BUTTON_LABEL_CLASS = "closeButtonLabel";
    private static final String POINTS_TITLE_CLASS_NAME = "pointsTitle";
    private static final String POINTS_CONTENTS_CLASS_NAME = "pointsContents";


    private LoveCalculatorService service;

    @Autowired
    public HomeController(LoveCalculatorService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showHomePage(Model model, Names names) {
        populateStaticContent(model);
        return "home";
    }

    @PostMapping(value = "/callback", params = "action=" + StringConstants.CHECK_BUTTON)
    public String calculate(Model model, @ModelAttribute Names names) {
        populateStaticContent(model);

        service.calculate(names);
        model.addAttribute("advice", service.advice());
        model.addAttribute("points", service.getPoints());
        return "home";
    }

    @PostMapping(value = "/callback", params = "action=" + StringConstants.CLOSE_BUTTON_LABEL)
    public String endTheGame(Model model, @ModelAttribute Names names) {
        populateStaticContent(model);

        service.restartTheGame();
        return "home";
    }


    private void populateStaticContent(Model model) {
        model.addAttribute(PAGE_TITLE_CLASS_NAME, StringConstants.PAGE_TITLE);
        model.addAttribute(INSTRUCTION_TITLE_CLASS_NAME, StringConstants.INSTRUCTION_TITLE);
        model.addAttribute(INSTRUCTION_CONTENTS_CLASS_NAME, StringConstants.INSTRUCTION_CONTENTS);
        model.addAttribute(ADVICE_TITLE_CLASS_NAME, StringConstants.ADVICE_TITLE);
        model.addAttribute(ADVICE_CONTENTS_CLASS_NAME, StringConstants.ADVICE_CONTENTS);

        model.addAttribute(INPUT_MALE_NAME_LABEL_CLASS_NAME, StringConstants.INPUT_MALE_NAME_LABEL);
        model.addAttribute(INPUT_FEMALE_NAME_LABEL_CLASS_NAME, StringConstants.INPUT_FEMALE_NAME_LABEL);

        model.addAttribute(INPUT_MALE_NAME_PLACEHOLDER_NAME_CLASS, StringConstants.INPUT_MALE_NAME_PLACEHOLDER);
        model.addAttribute(INPUT_FEMALE_NAME_PLACEHOLDER_NAME_CLASS, StringConstants.INPUT_FEMALE_NAME_PLACEHOLDER);


        model.addAttribute(CHECK_BUTTON_NAME_CLASS, StringConstants.CHECK_BUTTON);
        model.addAttribute(DISCLAIMER_CONTENTS_NAME_CLASS, StringConstants.DISCLAIMER_CONTENTS);
        model.addAttribute(DISCLAIMER_TITLE_NAME_CLASS, StringConstants.DISCLAIMER_TITLE);

        model.addAttribute(CLOSE_BUTTON_LABEL_CLASS, StringConstants.CLOSE_BUTTON_LABEL);
        model.addAttribute(LOVECALCULATOR_SERVICE_OBJECT_NAME, service);

        model.addAttribute(POINTS_TITLE_CLASS_NAME, StringConstants.POINTS_TITLE);
        model.addAttribute(POINTS_CONTENTS_CLASS_NAME, StringConstants.POINTS_CONTENTS);


    }
}
