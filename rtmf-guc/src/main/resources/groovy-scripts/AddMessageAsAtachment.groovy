/*
 * Copyright (c) 2009-2011 Gemeente Rotterdam
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the European Union Public Licence (EUPL),
 * version 1.1 (or any later version).
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * European Union Public Licence for more details.
 *
 * You should have received a copy of the European Union Public Licence
 * along with this program. If not, see
 * http://www.osor.eu/eupl/european-union-public-licence-eupl-v.1.1
*/
import javax.activation.DataHandler;
import org.mule.api.MuleMessage;
import javax.mail.util.ByteArrayDataSource;



muleMessage = (MuleMessage)message
assert muleMessage != null : "Het message object is null"

muleMessage.addAttachment("terugmelding", new DataHandler(new ByteArrayDataSource((String) payload, "Content-Type: multipart/mixed")))

return message