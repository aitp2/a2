import { stepData } from '../services/api';

export default {
  namespace: 'stepslog',

  state: {
	  	stepadvancedOperation1: [],
	  	stepadvancedLoading: true,
	  },

  effects: {
    *fetchList(_, { call, put }) {
        yield put({
            type: 'changeLoading',
            payload: { stepadvancedLoading: true },
          });
          const response = yield call(stepData);
          yield put({
            type: 'show',
            payload: response,
          });
          yield put({
            type: 'changeLoading',
            payload: { stepadvancedLoading: false },
          });
        },
  },

  reducers: {
	    show(state, { payload }) {
	        return {
	          ...state,
	          ...payload,
	        };
	      },
	      changeLoading(state, { payload }) {
	        return {
	          ...state,
	          ...payload,
	        };
	      },
	    },
};
