package guru.springframework.msscssm.config;

import java.util.EnumSet;

import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;

import guru.springframework.msscssm.domain.PaymentEvent;
import guru.springframework.msscssm.domain.PaymentState;

/**
 * Created by jt on 2019-07-23.
 */

public class StateMachineConfig extends StateMachineConfigurerAdapter<PaymentState, PaymentEvent>{
	@Override
	public void configure(StateMachineStateConfigurer<PaymentState, PaymentEvent> states) throws Exception {
		states.withStates()
		.initial(PaymentState.NEW)
		.states(EnumSet.allOf(PaymentState.class))
		.end(PaymentState.AUTH)
		.end(PaymentState.PRE_AUTH_ERROR)
		.end(PaymentState.AUTH_ERROR);
	}
}