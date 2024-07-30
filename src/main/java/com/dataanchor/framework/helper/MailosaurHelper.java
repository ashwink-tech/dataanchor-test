package com.dataanchor.framework.helper;

import com.dataanchor.framework.config.GlobalConfigReader;
import com.dataanchor.framework.utilities.LogUtil;
import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

import java.io.IOException;

import static com.dataanchor.framework.utilities.LogUtil.*;
import static java.util.regex.Pattern.compile;

public class MailosaurHelper {

    private MailosaurHelper() {
        throw new IllegalStateException("MailosaurHelper class");
    }

    public static String getOTP() throws MailosaurException, IOException {
        info("Getting OTP for authentication using Mailosaur");
        var mailosaur = new MailosaurClient(GlobalConfigReader.getProperty().apiKey());
        mailosaur.messages().deleteAll(GlobalConfigReader.getProperty().serverId());

        var params = new MessageSearchParams();
        params.withServer(GlobalConfigReader.getProperty().serverId());

        var criteria = new SearchCriteria();
        criteria.withSentTo("settlers-cabin@" + GlobalConfigReader.getProperty().serverDomain());

        Message message = mailosaur.messages().get(params, criteria);
        return readOtp(message);
    }

    public static String readOtp(Message message) {
        var pattern = compile(".*([0-9]{6}).*");
        var matcher = pattern.matcher(message.text().body());
        matcher.find();
        return matcher.group(1);
    }
}
