const CHANGE = 'change' as const;

export const change = (name: string, opt: string) => ({
  type: CHANGE,
  name,
  opt,
});

type payloadState = {
  name: string;
  opt: string;
};

type changeAction = ReturnType<typeof change>;

const initialState: payloadState = {
  name: '',
  opt: '',
};

const changeBtn = (
  state: payloadState = initialState,
  action: changeAction
) => {
  switch (action.type) {
    case CHANGE:
      return { ...state, name: action.name, opt: action.opt };
    default:
      return () => console.log('undefined');
  }
};

export default changeBtn;
