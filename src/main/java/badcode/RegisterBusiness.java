package badcode;

import java.util.Arrays;

public class RegisterBusiness {

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        Integer speakerId;

        validateSpeaker(speaker);
        validateEmail(speaker.getEmail());

        try {
            speakerId = repository.saveSpeaker(speaker);
        } catch (Exception exception) {
            throw new SaveSpeakerException("Can't save a speaker.");
        }

        return speakerId;
    }

    private void validateEmail(String email) {
        String[] domains = {"gmail.com", "live.com"};
        String emailDomain = getEmailDomain(email);
        if (!contain(domains, emailDomain)) {
            throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
        }
    }

    private boolean contain(String[] domains, String emailDomain) {
        return Arrays.asList(domains).contains(emailDomain);
    }

    private void validateSpeaker(Speaker speaker) {
        if (isNullOrEmpty(speaker.getFirstName())) throw new ArgumentNullException("First name is required.");
        if (isNullOrEmpty(speaker.getLastName())) throw new ArgumentNullException("Last name is required.");
        if (isNullOrEmpty(speaker.getEmail())) throw new ArgumentNullException("Email is required.");

    }

    private boolean isNullOrEmpty(String value) {
        return value == null || "".equals(value.trim());
    }

    public String getEmailDomain(String email) {
        String[] inputs = email.trim().split("@");
        if (inputs.length == 2) return inputs[1];
        throw new DomainEmailInvalidException();
    }

}
