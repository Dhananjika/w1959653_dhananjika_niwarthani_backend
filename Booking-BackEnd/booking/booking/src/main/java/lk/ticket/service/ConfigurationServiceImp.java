package lk.ticket.service;

import com.google.gson.Gson;
import lk.ticket.model.Configuration;
import lk.ticket.repository.ConfigurationRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.time.LocalDate;

@Service
public class ConfigurationServiceImp implements ConfigarationService{
    private static final Logger logger = Logger.getLogger(ConfigurationServiceImp.class);
    private Gson gson = new Gson();

    private final ConfigurationRepository configurationRepository;

    @Autowired
    public ConfigurationServiceImp(ConfigurationRepository configurationRepository){
        this.configurationRepository = configurationRepository;
    }

    /**
     *  This method is used to submit the configuration details
     *
     *  @in  totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity
     *  @throws Exception
     *  @out resultMessage
     * */

    @Override
    public String submitConfiguration(Configuration configuration, String user){
        logger.info("Method called");
        LocalDate localDate = LocalDate.now();
        return configurationRepository.submitConfiguration(configuration, user, localDate.toString());
    }

    /**
     *  This method is used to save the configuration details to json file
     *
     *  @in  totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity
     *  @throws Exception
     *  @out jsonFile
     * */
    public void saveJsonFile(Configuration configuration){
        try {
            String pathToJsonFile = "src/json/configuration.json";
            FileWriter fileWriter = new FileWriter(pathToJsonFile);
            gson.toJson(fileWriter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
