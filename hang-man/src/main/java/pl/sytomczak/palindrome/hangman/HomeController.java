package pl.sytomczak.palindrome.hangman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private static final String PAGE_TITLE_CLASS_NAME = "pageTitle";
    private static final String SUBTITLE_CLASS_NAME = "subtitle";
    private static final String INSTRUCTION_TITLE_CLASS_NAME = "instructionTitle";
    private static final String INSTRUCTION_CONTENTS_CLASS_NAME = "instructionContents";
    private static final String ALPHABET_CLASS_NAME = "alphabet";
    private static final String ALPHABET_CONTENTS_CLASS_NAME = "alphabetContents";
    private static final String ADVERTISING_CLASS_NAME = "sideTitle";
    private static final String ADVERTISING_CONTENTS_CLASS_NAME = "sideContents";
    private static final String INPUT_LABEL_CLASS_NAME = "inputLabel";
    private static final String INPUT_PLACEHOLDER_NAME_CLASS = "inputPlaceholder";
    private static final String SUBMIT_NAME_CLASS = "submit";
    private static final String DISCLAIMER_NAME_CLASS = "disclaimer";
    private static final String HANGMAN_SERVICE_OBJECT_NAME = "service";
    private static final String CLOSE_BUTTON_LABEL_CLASS = "closeButtonLabel";

    private HangmanService service;

    @Autowired
    public HomeController(HangmanService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showHomePage(Model model, HangmanStats stats) {
        populateStaticContent(model);
        return "home";
    }

    @PostMapping("/callback")
    public String getBackToHome(Model model, @ModelAttribute HangmanStats stats) {
        populateStaticContent(model);
        if (service.isGameFinished()) {
            service.restartTheGame();
        } else {
            Character typedLetter = stats.getTypedLetter();
            service.processTheTry(typedLetter);
        }

        return "home";
    }

    private void populateStaticContent(Model model) {
        model.addAttribute(PAGE_TITLE_CLASS_NAME, StringConstants.PAGE_TITLE);
        model.addAttribute(SUBTITLE_CLASS_NAME, StringConstants.SUBTITLE);
        model.addAttribute(INSTRUCTION_TITLE_CLASS_NAME, StringConstants.INSTRUCTION_TITLE);
        model.addAttribute(INSTRUCTION_CONTENTS_CLASS_NAME, StringConstants.INSTRUCTION_CONTENTS);
        model.addAttribute(ALPHABET_CLASS_NAME, StringConstants.ALPHABET_NAME);
        model.addAttribute(ALPHABET_CONTENTS_CLASS_NAME, StringConstants.ALPHABET_CONTENTS);
        model.addAttribute(ADVERTISING_CLASS_NAME, StringConstants.ADVERTISING_SPACE);
        model.addAttribute(ADVERTISING_CONTENTS_CLASS_NAME, StringConstants.ADVERTISING_CONTENTS);
        model.addAttribute(INPUT_LABEL_CLASS_NAME, StringConstants.INPUT_LABEL);
        model.addAttribute(INPUT_PLACEHOLDER_NAME_CLASS, StringConstants.INPUT_PLACEHOLDER);
        model.addAttribute(SUBMIT_NAME_CLASS, StringConstants.SUBMIT);
        model.addAttribute(DISCLAIMER_NAME_CLASS, StringConstants.DISCLAIMER);
        model.addAttribute(CLOSE_BUTTON_LABEL_CLASS, StringConstants.CLOSE_BUTTON_LABEL);

        model.addAttribute(HANGMAN_SERVICE_OBJECT_NAME, service);
    }
}

